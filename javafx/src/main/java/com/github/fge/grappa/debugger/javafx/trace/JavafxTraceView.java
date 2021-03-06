package com.github.fge.grappa.debugger.javafx.trace;

import com.github.fge.grappa.debugger.common.GuiTaskRunner;
import com.github.fge.grappa.debugger.javafx.common.JavafxView;
import com.github.fge.grappa.debugger.javafx.trace.tabs.matches.JavafxMatchesTabView;
import com.github.fge.grappa.debugger.javafx.trace.tabs.rules.JavafxRulesTabView;
import com.github.fge.grappa.debugger.javafx.trace.tabs.tree.JavafxTreeTabView;
import com.github.fge.grappa.debugger.javafx.trace.tabs.treedepth.JavafxTreeDepthTabView;
import com.github.fge.grappa.debugger.main.MainWindowView;
import com.github.fge.grappa.debugger.trace.TracePresenter;
import com.github.fge.grappa.debugger.trace.TraceView;
import com.github.fge.grappa.debugger.trace.tabs.matches.MatchesTabPresenter;
import com.github.fge.grappa.debugger.trace.tabs.rules.RulesTabPresenter;
import com.github.fge.grappa.debugger.trace.tabs.tree.TreeTabPresenter;
import com.github.fge.grappa.debugger.trace.tabs.treedepth.TreeDepthTabPresenter;
import com.github.fge.grappa.internal.NonFinalForTesting;
import com.google.common.annotations.VisibleForTesting;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.util.Objects;

@ParametersAreNonnullByDefault
@NonFinalForTesting
public class JavafxTraceView
    extends JavafxView<TracePresenter, TraceDisplay>
    implements TraceView
{
    private final GuiTaskRunner taskRunner;
    private final MainWindowView parentView;

    private int lastLoaded = 0;

    public JavafxTraceView(final GuiTaskRunner taskRunner,
        final MainWindowView parentView)
        throws IOException
    {
        super("/javafx/trace.fxml");
        this.taskRunner = Objects.requireNonNull(taskRunner);
        this.parentView = Objects.requireNonNull(parentView);
    }

    @Override
    public void showLoadToolbar()
    {
        display.pane.setTop(display.toolbar);
    }

    @Override
    public void hideLoadToolbar()
    {
        display.pane.setTop(null);
    }

    @Override
    public void reportStatus(final int total, final int loaded)
    {
        final int loadedThisRound = loaded - lastLoaded;
        lastLoaded = loaded;

        final double pct = (double) loaded / total;
        display.progressBar.setProgress(pct);

        @SuppressWarnings("AutoBoxing")
        final StringBuilder sb = new StringBuilder()
            .append(String.format("%.02f%%", pct * 100));

        if (loadedThisRound != 0) {
            sb.append(", ");

            // Rough estimate; it works since we are polled every second
            int estimate = (total - loaded) / loadedThisRound;

            final int seconds = estimate % 60;
            estimate /= 60;

            if (estimate > 0)
                sb.append(estimate).append(" min ");
            sb.append(seconds).append(" s remaining");
        }

        display.progressMessage.setText(sb.toString());
    }

    @Override
    public void showLoadComplete()
    {
        display.progressMessage.setText("load complete");
    }

    @Override
    public void disableTabRefresh()
    {
        display.refresh.setDisable(true);
    }

    @Override
    public void enableTabRefresh()
    {
        display.refresh.setDisable(false);
    }

    @Override
    public void loadTreeTab(final TreeTabPresenter tabPresenter)
    {
        final JavafxTreeTabView tabView;
        try {
            tabView = getTreeTabView();
        } catch (IOException e) {
            parentView.showError("Load error", "Unable to load tree tab", e);
            return;
        }
        tabView.getDisplay().setPresenter(tabPresenter);
        tabPresenter.setView(tabView);
        display.treeTab.setContent(tabView.getNode());
    }

    @VisibleForTesting
    JavafxTreeTabView getTreeTabView()
        throws IOException
    {
        return new JavafxTreeTabView(taskRunner);
    }

    @Override
    public void loadMatchesTab(final MatchesTabPresenter tabPresenter)
    {
        final JavafxMatchesTabView tabView;
        try {
            tabView = getMatchesTabView();
        } catch (IOException e) {
            parentView.showError("Load error", "Unable to load matches tab", e);
            return;
        }
        tabView.getDisplay().setPresenter(tabPresenter);
        tabPresenter.setView(tabView);
        display.matchesTab.setContent(tabView.getNode());
    }

    @VisibleForTesting
    JavafxMatchesTabView getMatchesTabView()
        throws IOException
    {
        return new JavafxMatchesTabView();
    }

    @Override
    public void loadRulesTab(final RulesTabPresenter tabPresenter)
    {
        final JavafxRulesTabView tabView;

        try {
            tabView = getRulesTabView();
        } catch (IOException e) {
            parentView.showError("Load error", "Unable to load rules tab", e);
            return;
        }
        tabView.getDisplay().setPresenter(tabPresenter);
        tabPresenter.setView(tabView);
        display.rulesTab.setContent(tabView.getNode());
    }

    @VisibleForTesting
    JavafxRulesTabView getRulesTabView()
        throws IOException
    {
        return new JavafxRulesTabView();
    }

    @Override
    public void loadTreeDepthTab(final TreeDepthTabPresenter tabPresenter)
    {
        final JavafxTreeDepthTabView tabView;

        try {
            tabView = getTreeDepthTabView();
        } catch (IOException e) {
            parentView.showError("Load error", "Unable to load tree depth tab",
                e);
            return;
        }

        tabView.getDisplay().setPresenter(tabPresenter);
        tabPresenter.setView(tabView);
        display.treeDepthTab.setContent(tabView.getNode());
    }

    @VisibleForTesting
    JavafxTreeDepthTabView getTreeDepthTabView()
        throws IOException
    {
        return new JavafxTreeDepthTabView();
    }
}
