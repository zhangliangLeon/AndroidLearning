package com.example.myapplication.ServiceTest.DownLoadService;

public interface MyDownLoadListener {
    public void succuss();
    public void fail();
    public void pause();
    public void cancle();
    public void onProgress(int progress);

}
