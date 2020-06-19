package com.app.bhaskar.easypaisa.utils

object Constants {

    const val BASE_URL = "https://retail.easypaisa.in/android/ep/secure/server/php/"
    //    API const
    const val API_LOGIN = "userLogin"

    //    api header
    const val HEADER_CONTENT_TYPE = "Content-Type: application/x-www-form-urlencoded"

    interface ApiHeaders{
        companion object{
            const val API_TYPE_JSON = "application/json"
            const val AUTHORIZATION = "authorization"
        }
    }

    interface ApiMethod{
        companion object{
            const val API_LOGIN = "auth/check"
            const val API_SEND_TOKEN = "auth/reset/request"
            const val API_FORGOT_PASSWORD = "auth/reset/update"
            const val API_WALLET_BAL = "getbalance"
            const val API_USER_REQ_DATA = "faeps/getrequireddata"
        }
    }

    interface AepsServices{
        companion object{
            const val AEPS_WITHDRAW = "aeps_withdraw"
            const val AEPS_BAL_INFO = "aeps_bal_info"
        }
    }

    interface AvailableService{
        companion object{
            const val SERVICE_YBL_AEPS = 1
            const val SERVICE_AEPS_ICICI_EP = 6
            const val SERVICE_FINO_AEPS = 2
            const val SERVICE_ICICI_AEPS = 3
            const val SERVICE_MICRO_ATM = 4
            const val SERVICE_MONEY_TRANS = 5
        }
    }

    interface ApiResponse{
        companion object{
            const val RES_SUCCESS = "TXN"
            const val RES_ERROR: String = "ERR"
            const val RES_FAIL: String = "TXF"
            const val RES_PENDING: String = "TUP"
        }
    }


    interface DIRECTORY {
        companion object {

            // Internal Storage Folder Name
            val ROOT_DIR = "EasyPaisa"
            val PROFILE_DIR = "Profile"
            val IMAGE_DIR = "Image"
        }
    }

    interface SharedPrefKey{
        companion object{
            const val LOGGEDIN_USER = "user_info"
            const val USER_REQUIRED_DATA = "user_required_date"
            const val DEVICE_TOKEN = "device_token"
            const val USER_LATLNG = "USER_LATLNG"
            const val PREF_FILE = "PREF_FILE_EASY_PAISA"
        }
    }

    interface APP_PERMISSION {
        companion object {
            const val PERMISSIONS_SMS_READ = 301
            const val PERMISSIONS_CURRENT_LOCATION = 302
            const val GPS_ENABLED = 303
            const val PLAY_SERVICES_RESOLUTION_REQUEST = 9000
        }
    }

    interface UI{
        companion object{
            const val FOR_START_TIME = 0
            const val TYPE_PHOTO_PICK_FROM_FILE = 123
            const val MY_PERMISSIONS_REQUEST_CAMERA= 1212
            const val MY_PERMISSIONS_REQUEST_STORAGE_READ= 1234
            const val TYPE_PHOTO_PICK_FROM_CAMERA= 1236
            const val FOR_END_TIME = 1
            const val FILE_SELECT_CODE = 1010
            const val RC_SIGN_IN = 1011
            const val LOCATION_FOR_PICKUP = 1012
            const val LOCATION_FOR_DROP_OFF = 1013
            const val EDIT_PROFILE = 1014
            const val FROM_ADDRESS_SCREEN = "FROM_ADDRESS_SCREEN"
            const val SET_LOCATION = "SET_LOCATION"
            const val PLACE = "PLACE"
            const val PA_ID= "pa_id"
            const val CUSTOMER_ID= "customer_id"
            const val PAYMENTHISTORY= "PaymentHistory"
            const val EDIT_CUSTOMER_TASK= "EDIT_CUSTOMER_TASK"
            const val MOBILE_NUMBER= "MOBILE_NUMBER"
        }
    }

}