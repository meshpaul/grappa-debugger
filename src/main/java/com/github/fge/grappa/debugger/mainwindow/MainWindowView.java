package com.github.fge.grappa.debugger.mainwindow;

import com.github.fge.grappa.debugger.common.db.DbLoadStatus;
import com.github.fge.grappa.debugger.csvtrace.CsvTracePresenter;
import com.github.fge.grappa.debugger.csvtrace.newmodel.ParseInfo;

import javax.annotation.Nullable;
import java.nio.file.Path;

public interface MainWindowView
{
    @Nullable
    Path chooseFile();

    void setWindowTitle(String windowTitle);

    void showError(String header, String message, Throwable throwable);

    void setLabelText(String text);

    void attachTrace(CsvTracePresenter presenter);

    void reportProgress(DbLoadStatus status, ParseInfo info);

    void initLoad();

    void loadComplete();

    void loadAborted();
}
