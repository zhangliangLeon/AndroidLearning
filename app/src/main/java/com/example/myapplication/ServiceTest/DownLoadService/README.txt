这里设计了一个下载服务
前台 -> 服务 -> syncTask

1.编写一个接口用于事件响应
2.编写syncTask
    里面有一个事件响应的listner
    1.doInBackground 执行下载
    2.onProgressUpdate
        在下载过程中不断的调用publishProgress方法时会调用此方法进行进度条刷新
        进度条刷新的具体执行在 事件响应的listner中执行
    3.onPostExecute
        执行下载过程中会返回执行结果；包括成功、失败、暂停、取消等
        具体的执行在事件响应的listner中执行
3.编写Service
    1.编写  事件响应的listner  并使用该listner构建syncTask
    2.编写binder 对activity提供事件响应api
    