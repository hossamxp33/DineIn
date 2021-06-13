package com.example.dinein.models

class User {

    var isSuccess: Boolean = false
    var data: DataBean? = null

    class DataBean {
        /**
         * id : 5
         * username : admin
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjUsImV4cCI6MTU1NTUxOTM1N30.vQFx5wAdDKPcMqHixwdIq7z5hQK0dLm5rXo4g-VHLek
         */

        var id: Int = 0
        var username: String? = null
        var token: String? = null
    }
}
