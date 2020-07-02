package com.example.myapplication.ServiceTest.AsyncTask;

import android.os.AsyncTask;

/*
    param: 执行任务时需要传入的参数
    progress: 后台执行任务是，如果需要在界面上现当前的进度，则使用这里制定的范型作为进度单元
    Result: 任务执行完毕之后的返回值
 */
public class MyAsyncTask extends AsyncTask<Void,Integer,Boolean> {
    //在后台任务执行之前调用，用于进行一些界面的初始化，比如显示一个进度条对话框
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //这个方法中的所有代码都会在子线程中运行，我们应该在这里处理耗时任务
    //这个方法中不可以进行UI操作，如果需要，比如反馈当前任务的执行进度，可以调用publishProgress方法
    @Override
    protected Boolean doInBackground(Void... voids) {
        return null;
    }

    //当后台任务调用了publishProgress方法后，这个方法很快被调用，这个方法中的参数就是后台任务重传递过来的，在这个方法中可以对ui进行操作
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //当后台执行完毕，返回结果时会调用此的方法，可以再次进行一些ui操作，比如关闭进度条对话框等
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
