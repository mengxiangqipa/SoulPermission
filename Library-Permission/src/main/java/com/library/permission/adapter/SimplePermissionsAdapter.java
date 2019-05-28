package com.library.permission.adapter;

import com.library.permission.bean.Permission;
import com.library.permission.callbcak.CheckRequestPermissionsListener;


public abstract class SimplePermissionsAdapter implements CheckRequestPermissionsListener {
    @Override
    public void onAllPermissionOk(Permission[] allPermissions) {

    }

    @Override
    public void onPermissionDenied(Permission[] refusedPermissions) {

    }
}
