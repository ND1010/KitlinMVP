package com.app.bhaskar.easypaisa.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS
import android.webkit.MimeTypeMap
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.app.dhruv.kotlinmvp.R
import com.app.dhruv.kotlinmvp.ui.dialog.DialogAlert
import com.google.android.material.snackbar.Snackbar
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern


class Utils {

    companion object {
        private val indianLocal = Locale("en", "IN")
        private val cache = Hashtable<String, Typeface>()
        val EMAIL_ADDRESS_PATTERN =
                Pattern.compile("[a-zA-Z0-9\\+\\._%\\-\\+]{1,256}" + "@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+")
        private var progressDialog: Dialog? = null

        fun isValidEmail(email: String): Boolean {
            return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
        }

        fun formatAmount(amount: Double): String {
            //return AppConstants.RUPEE_SYMBOL + String.format(" %.2f", Amount);
            val formatter = NumberFormat.getCurrencyInstance(indianLocal)
            return formatter.format(amount).trim { it <= ' ' }
        }

        fun hideKeyboard(aContext: Activity?) {
            if (aContext != null) {
                val im =
                        aContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if (im != null) {
                    im.hideSoftInputFromWindow(
                            aContext.window.decorView.windowToken,
                            HIDE_NOT_ALWAYS
                    )
                }
            }
        }

        /*
     * For Set Current Timestamp Name
     * */
        fun getDateString(): String {
            return SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        }

        fun getRootDir(Directory: String, subDirectory: String): File {

            val root = Environment.getExternalStorageDirectory().toString()
            val myDir = File(root + "/"
                    + Constants.DIRECTORY.ROOT_DIR + "/" + Directory + "/" + subDirectory)
            myDir.mkdirs()
            return myDir
        }

        fun getPath(context: Context, uri: Uri): String {
            val projection = arrayOf(MediaStore.Images.Media.DATA)
            var cursor: Cursor? = null
            try {
                cursor = context.contentResolver.query(uri, projection, null, null, null)
                val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return ""
            } finally {
                if (cursor != null) {
                    cursor.close()
                }
            }
            return ""
        }

        // url = file path or whatever suitable URL you want.
        fun getMimeType(url: String): String? {
            var type: String? = null
            val extension: String? = MimeTypeMap.getFileExtensionFromUrl(url)
            if (extension != null) {
                type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            }
            return type
        }

        fun getRequest(reqString: String): RequestBody {
            val mediaType = Constants.ApiHeaders.API_TYPE_JSON.toMediaTypeOrNull()
            return RequestBody.create(mediaType, reqString)
        }

        fun showAlert(context: Context, message: String, title: String, yesClick: View.OnClickListener) {
            try {
                DialogAlert(context).setMessage(message)
                        .setPositiveButton(context.getString(R.string.yes), yesClick)
                        .setNegativeButton(context.getString(R.string.no), View.OnClickListener {
                            DialogAlert(context).dismiss()
                        }).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


//        @SuppressLint("SimpleDateFormat")
//        fun isValideFutureTime(fromTime: String, toTime: String): Boolean {
//            val sdf = SimpleDateFormat("kk:mm:ss")
//            val datefrom = sdf.parse(fromTime)
//            val toTime = sdf.parse(toTime)
//            return !datefrom.before(toTime)
//        }
//
//        @SuppressLint("SimpleDateFormat")
//        fun isValideFutureDate(fromDate: String, toDate: String): Boolean {
//            val sdf = SimpleDateFormat("yyyy/MM/dd")
//            try {
//                if (sdf.parse(fromDate).before(sdf.parse(toDate))) {
//                    return true//If start date is before end date
//                } else if (sdf.parse(fromDate).equals(sdf.parse(toDate))) {
//                    return true//If two dates are equal
//                } else {
//                    return false //If start date is after the end date
//                }
//            } catch (e: ParseException) {
//                // TODO Auto-generated catch block
//                e.printStackTrace()
//            }
//            return false
//        }

        @SuppressLint("SimpleDateFormat")
        fun isSameDate(fromDate: String, toDate: String): Boolean {
            fromDate.replace("/", "-")
            val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")

            try {
                val toTaskDate = sdf.parse(toDate.replace("/", "-"))
                val fromTaskDate = sdf.parse(fromDate.replace("/", "-"))
                val miliToDate = toTaskDate.time
                val miliFromDate = fromTaskDate.time
                return miliFromDate < miliToDate
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return false
        }

        @SuppressLint("SimpleDateFormat")
        fun isSameDateYYYYMMDD(fromDate: String, toDate: String): Boolean {
            val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
            try {
                return if (sdf.parse(fromDate).before(sdf.parse(toDate))) {
                    true
                } else {
                    sdf.parse(fromDate) == sdf.parse(toDate)
                }
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return false
        }

        fun hasReadFilePermission(mContest: Context): Boolean {
            return !(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(mContest, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        }

        fun hasCameraPermission(mContest: Context): Boolean {
            return !(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(mContest, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        }

        fun hasLocaionPermission(mContest: Context): Boolean {
            return !(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(mContest, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        }


        fun showSnackBar(
                view: View,
                message: String,
                time: Int,
                isTypeError: Boolean,
                context: Context
        ) {

            val snackbar = Snackbar.make(view, message, time)
            val snackBarView = snackbar.view
            val snackTextView =
                    snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            snackTextView.maxLines = 4
            if (isTypeError) {
                snackBarView.setBackgroundColor(
                        ContextCompat.getColor(
                                context,
                                android.R.color.holo_red_dark
                        )
                )
            } else {
                snackBarView.setBackgroundColor(
                        ContextCompat.getColor(
                                context,
                                android.R.color.holo_green_dark)
                )
            }
            snackbar.show()
        }

        fun isMyServiceRunning(mContext: Context, serviceClass: Class<*>): Boolean {
            val manager = mContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
                if (serviceClass.name == service.service.className) {
                    return true
                }
            }
            return false
        }

        fun showToast(message: CharSequence, context: Context) =
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

        fun msToString(ms: Long): String {
            val totalSecs = ms / 1000
            val hours = totalSecs / 3600
            val mins = totalSecs / 60 % 60
            val secs = totalSecs % 60
            val minsString = if (mins == 0L)
                "00"
            else
                if (mins < 10)
                    "0$mins"
                else
                    "" + mins
            val secsString = if ((secs == 0L))
                "00"
            else
                (if ((secs < 10))
                    "0$secs"
                else
                    "" + secs)
            if (hours > 0)
                return (hours).toString() + ":" + minsString + ":" + secsString
            else return if (mins > 0)
                (mins).toString() + ":" + secsString
            else
                ":$secsString"
        }

        fun isNetworkConnected(context: Context): Boolean {
            val cm = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnected
        }


        fun getTypeFace(aContext: Context, assetFile: String?): Typeface? {
            synchronized(cache) {
                if (!cache.containsKey(assetFile)) {
                    try {
                        val t = Typeface.createFromAsset(aContext.assets,
                                assetFile)
                        cache.put(assetFile, t)
                    } catch (e: Exception) {
                        Log.e(TAG, "Could not get1 typeface '" + assetFile
                                + "' because " + e.message)
                        return null
                    }

                }
                return cache.get(assetFile)
            }
        }

        fun getDate(milliSeconds: Long, dateFormat: String): String {
            // Create a DateFormatter object for displaying date in specified format.
            val formatter = SimpleDateFormat(dateFormat)

            // Create a calendar object that will convert the date and time value in milliseconds to date.
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliSeconds
            return formatter.format(calendar.time)
        }

        /**
         * This method is used to show progress indicator dialog with message when
         * web service is called.
         */
        fun showProgressDialog(context: Context?, message: String) {

            if (context != null && !(context as Activity).isFinishing) {
                if (progressDialog == null || !progressDialog!!.isShowing) {
                    progressDialog = Dialog(context)
                    progressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    try {
                        val dividerId = progressDialog!!.context
                                .resources.getIdentifier("android:id/titleDivider", null, null)
                        val divider = progressDialog!!.findViewById<View>(dividerId)
                        if (divider != null)
                            divider.setBackgroundColor(context.resources.getColor(android.R.color.transparent))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    progressDialog!!.setContentView(R.layout.custom_progress)
                    val tvMessage = progressDialog!!.findViewById<View>(R.id.txtMessage) as TextView
                    if (message != "") {
                        tvMessage.text = message
                    }
                    progressDialog!!.setCancelable(false)
                    if (!context.isFinishing)
                        progressDialog!!.show()
                }
            }
        }

        fun hideProgressDialog() {
            try {
                if (progressDialog != null && progressDialog!!.isShowing()) {
                    progressDialog!!.dismiss()
                }
            } catch (throwable: Throwable) {

            } finally {
                progressDialog = null
            }
        }

        fun getFileTypeFromUri(context: Context, uri: Uri): String? {
            val cR = context.contentResolver
            val mime = MimeTypeMap.getSingleton()
            return mime.getExtensionFromMimeType(cR.getType(uri))
        }

        fun getImageUri(viewActivity: Context, bitmap: Bitmap?): Uri? {
            val bytes = ByteArrayOutputStream()
            bitmap!!.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
            val path = MediaStore.Images.Media.insertImage(viewActivity.contentResolver, bitmap, "Title", null)
            return Uri.parse(path)

        }

        fun getFormattedDate(oldFormat: String, newFormat: String, date: String): String {
            val format1 = SimpleDateFormat(oldFormat)
            val format2 = SimpleDateFormat(newFormat)
            val startDate = format1.parse(date)
            return format2.format(startDate)
        }

        fun subStringlastString(text: String, char: String): String {
            var s = ""
            if (text.contains(char)) {
                val splitedText = text.split(char)
                if (splitedText.isNotEmpty()) {
                    s = splitedText[splitedText.size - 1]
                        return s
                }
            }
            return s
        }
        
    }
}