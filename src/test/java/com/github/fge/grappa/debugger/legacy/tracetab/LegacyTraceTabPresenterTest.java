package com.github.fge.grappa.debugger.legacy.tracetab;

import com.github.fge.grappa.buffers.InputBuffer;
import com.github.fge.grappa.debugger.legacy.stats.LegacyTraceEvent;
import com.github.fge.grappa.debugger.legacy.stats.ParsingRunTrace;
import com.github.fge.grappa.debugger.stats.ParseNode;
import com.github.fge.grappa.trace.TraceEventType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class LegacyTraceTabPresenterTest
{
    private LegacyTraceTabView view;
    private LegacyTraceTabModel model;
    private LegacyTraceTabPresenter presenter;
    private InputBuffer buffer;

    @SuppressWarnings("unchecked")
    @BeforeMethod
    public void init()
    {
        view = mock(LegacyTraceTabView.class);
        model = mock(LegacyTraceTabModel.class);
        buffer = mock(InputBuffer.class);
        when(model.getInputBuffer()).thenReturn(buffer);
        presenter = new LegacyTraceTabPresenter(model);
        presenter.setView(view);
    }

    // FIXME: too complicated
    @SuppressWarnings({ "unchecked", "AutoBoxing" })
    @Test
    public void loadTraceTest()
    {
        final long fakeDate = 87238987982713987L;
        final LegacyTraceEvent fakeEvent =
            new LegacyTraceEvent(TraceEventType.BEFORE_MATCH, 0L, 0, "", "", 0);
        final List<LegacyTraceEvent> events
            = Collections.singletonList(fakeEvent);

        final ParsingRunTrace trace = new ParsingRunTrace(fakeDate, events);

        when(model.getTrace()).thenReturn(trace);
        when(model.getTraceEvents()).thenReturn(events);

        presenter.loadTrace();

        verify(view).setInputBuffer(any(InputBuffer.class));
        verify(view).setParseDate(fakeDate);
        verify(view).setParseTree(any(ParseNode.class));
        verify(view).setInputBuffer(any(InputBuffer.class));
        verify(view).setStatistics(anyCollection(), anyInt());
        verify(view).setTraceEvents(same(events));
        verifyNoMoreInteractions(view);
    }

    @SuppressWarnings("AutoBoxing")
    @Test
    public void handleParseNodeShowSuccessTest()
    {
        final ParseNode node = mock(ParseNode.class);
        final int start = 4;
        final int end = 7;

        when(buffer.length()).thenReturn(20);
        when(node.isSuccess()).thenReturn(true);
        when(node.getStart()).thenReturn(start);
        when(node.getEnd()).thenReturn(end);

        presenter.handleParseNodeShow(node);

        verify(view).fillParseNodeDetails(same(node));
        verify(view).highlightSuccess(start, end);
        verifyNoMoreInteractions(view);
    }

    @SuppressWarnings("AutoBoxing")
    @Test
    public void handleParseNodeShowFailureTest()
    {
        final ParseNode node = mock(ParseNode.class);
        final int end = 21;

        when(buffer.length()).thenReturn(20);
        // This is the default but let's make it explicit
        when(node.isSuccess()).thenReturn(false);
        when(node.getEnd()).thenReturn(end);

        presenter.handleParseNodeShow(node);

        verify(view).fillParseNodeDetails(same(node));
        verify(view).highlightFailure(20);
    }

    @Test
    public void handleExpandParseTreeTest()
    {
        presenter.handleExpandParseTree();

        verify(view, only()).expandParseTree();
    }
}
