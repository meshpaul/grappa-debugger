package com.github.fge.grappa.debugger.tracetab;

import com.github.fge.grappa.buffers.InputBuffer;

public class TraceTabPresenter
{
    private final TraceTabModel model;
    private final InputBuffer buffer;

    private TraceTabView view;

    public TraceTabPresenter(final TraceTabModel model)
    {
        this.model = model;
        buffer = model.getInputBuffer();
    }

    public void setView(final TraceTabView view)
    {
        this.view = view;
    }
}
