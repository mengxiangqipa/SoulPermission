//package com.permission.permission;
//
//
//import android.Manifest;
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Toast;
//import com.library.permission.R;
//import com.library.permission.SoulPermission;
//import com.library.permission.bean.Permission;
//import com.library.permission.bean.Permissions;
//import com.library.permission.bean.Special;
//import com.library.permission.callbcak.CheckRequestPermissionListener;
//import com.library.permission.callbcak.CheckRequestPermissionsListener;
//import com.library.permission.callbcak.SpecialPermissionListener;
//
//public class ApiGuideActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_api_guide);
//    }
//
//    public void checkSinglePermission(View view) {
//        //you can also use checkPermissions() for a series of permissions
//        Permission checkResult = SoulPermission.getInstance().checkSinglePermission(Manifest.permission.ACCESS_FINE_LOCATION);
//        Toast.makeText(this, checkResult.toString(), Toast.LENGTH_SHORT).show();
//    }
//
//    public void requestSinglePermission(View view) {
//        SoulPermission.getInstance().checkAndRequestPermission(Manifest.permission.ACCESS_FINE_LOCATION,
//                //if you want do noting or no need all the callbacks you may use SimplePermissionAdapter instead
//                new CheckRequestPermissionListener() {
//                    @Override
//                    public void onPermissionGranted(Permission permission) {
//                        Toast.makeText(ApiGuideActivity.this, permission.toString() +
//                                "\n is ok , you can do your operations", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onPermissionDenied(Permission permission) {
//                        Toast.makeText(ApiGuideActivity.this, permission.toString() +
//                                " \n is refused you can not do next things", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    public void requestPermissions(View view) {
//        SoulPermission.getInstance().checkAndRequestPermissions(
//                Permissions.build(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
//                //if you want do noting or no need all the callbacks you may use SimplePermissionsAdapter instead
//                new CheckRequestPermissionsListener() {
//                    @Override
//                    public void onAllPermissionGranted(Permission[] allPermissions) {
//                        Toast.makeText(ApiGuideActivity.this, allPermissions.length + "permissions is ok" +
//                                " \n  you can do your operations", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onPermissionDenied(Permission[] refusedPermissions) {
//                        Toast.makeText(ApiGuideActivity.this, refusedPermissions[0].toString() +
//                                " \n is refused you can not do next things", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    public void requestSinglePermissionWithRationale(View view) {
//        SoulPermission.getInstance().checkAndRequestPermission(Manifest.permission.READ_CONTACTS,
//                new CheckRequestPermissionListener() {
//                    @Override
//                    public void onPermissionGranted(Permission permission) {
//                        Toast.makeText(ApiGuideActivity.this, permission.toString() +
//                                "\n is ok , you can do your operations", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onPermissionDenied(Permission permission) {
//                        // see CheckPermissionWithRationaleAdapter
//                        if (permission.shouldRationale()) {
//                            Toast.makeText(ApiGuideActivity.this, permission.toString() +
//                                    " \n you should show a explain for user then retry ", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(ApiGuideActivity.this, permission.toString() +
//                                    " \n is refused you can not do next things", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//
//    public void checkNotification(View view) {
//        boolean checkResult = SoulPermission.getInstance().checkSpecialPermission(Special.NOTIFICATION);
//        if (checkResult) {
//            Toast.makeText(view.getContext(), "Notification is enable", Toast.LENGTH_SHORT).show();
//        } else {
//            new AlertDialog.Builder(view.getContext())
//                    .setMessage("Notification is disable \n you may invoke checkAndRequestPermission and enable notification")
//                    .setPositiveButton("OK", null)
//                    .create()
//                    .show();
//        }
//    }
//
//    public void checkAndRequestNotification(final View view) {
//        //if you want do noting or no need all the callbacks you may use SimpleSpecialPermissionAdapter instead
//        SoulPermission.getInstance().checkAndRequestPermission(Special.NOTIFICATION, new SpecialPermissionListener() {
//            @Override
//            public void onGranted(Special permission) {
//                Toast.makeText(ApiGuideActivity.this, "Notification is enable now ", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onDenied(Special permission) {
//                new AlertDialog.Builder(view.getContext())
//                        .setMessage("Notification is disable \n you may invoke checkAndRequestPermission and enable notification")
//                        .setPositiveButton("OK", null)
//                        .create()
//                        .show();
//            }
//        });
//    }
//
//    public void checkAndRequestSystemAlert(View view) {
//        //if you want do noting or no need all the callbacks you may use SimpleSpecialPermissionAdapter instead
//        SoulPermission.getInstance().checkAndRequestPermission(Special.SYSTEM_ALERT, new SpecialPermissionListener() {
//            @Override
//            public void onGranted(Special permission) {
//                Toast.makeText(ApiGuideActivity.this, "System Alert is enable now ", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onDenied(Special permission) {
//                Toast.makeText(ApiGuideActivity.this, "System Alert is disable yet", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void checkAndRequestUnKnownSource(View view) {
//        //if you want do noting or no need all the callbacks you may use SimpleSpecialPermissionAdapter instead
//        SoulPermission.getInstance().checkAndRequestPermission(Special.UNKNOWN_APP_SOURCES, new SpecialPermissionListener() {
//            @Override
//            public void onGranted(Special permission) {
//                Toast.makeText(ApiGuideActivity.this, "install unKnown app  is enable now", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onDenied(Special permission) {
//                Toast.makeText(ApiGuideActivity.this, "install unKnown app  is disable yet", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void goApplicationSettings(View view) {
//        SoulPermission.getInstance().goPermissionSettings();
//    }
//
//    public void getTopActivity(View view) {
//        Activity activity = SoulPermission.getInstance().getTopActivity();
//        if (null != activity) {
//            Toast.makeText(activity, activity.getClass().getSimpleName() + " " + activity.hashCode(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//}
