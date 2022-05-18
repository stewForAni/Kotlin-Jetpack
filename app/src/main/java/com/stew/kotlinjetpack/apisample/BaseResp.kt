package com.stew.kotlinjetpack.apisample

class BaseResp<T> {
    var errorCode: Int? = null
    var errorMsg: String? = null
    var data: T? = null
}
