package com.hafiz.expensetracker.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hafiz.expensetracker.R;
import com.hafiz.expensetracker.constant.BundleKeys;
import com.hafiz.expensetracker.util.Utils;

public class BaseActivity extends AppCompatActivity {

    protected Context baseContext;
    private ProgressDialog progressDialog;
    private int progressDialogCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @CallSuper
    protected void init() {
        initVariable();

        initViewReference();
        initListener();

        initFragmentVariable();

        subscribeUi();

        populateUi();

        initRequest();
    }

    protected void initVariable() {
        initViewModel();
        initBundleVariable();
        initOrganizationSettingsVariable();
        baseContext = this;
    }

    protected void initViewReference() {

    }

    protected void initListener() {

    }

    protected void initFragmentVariable() {

    }

    protected void subscribeUi() {

    }

    protected void populateUi() {
        populateUiDependingOnPermission();
    }

    protected void initRequest() {

    }

    protected void initViewModel() {

    }

    protected void initBundleVariable() {

    }

    protected void initOrganizationSettingsVariable() {

    }

    protected void populateUiDependingOnPermission() {

    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    protected void showToast(int id) {
        showToast(getResources().getString(id));
    }

    protected void showAlertDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.action_dialog_ok, null)
                .create().show();
    }

    protected void showAlertDialog(int title, int message, boolean cancelable,
                                   DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(cancelable)
                .setPositiveButton(R.string.action_dialog_ok, listener)
                .create().show();
    }

    protected void showAlertDialog(int title, String message, boolean cancelable,
                                   DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(cancelable)
                .setPositiveButton(R.string.action_dialog_ok, listener)
                .create().show();
    }

    protected void showAlertDialog(String message,
                                   DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(R.string.action_dialog_ok, listener)
                .create().show();
    }

    protected void showAlertDialog(int title, int message, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.action_dialog_ok, listener)
                .create().show();
    }

    protected void showAlertDialog(int title, String message, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.action_dialog_ok, listener)
                .create().show();
    }

    protected void showAlertDialog(int title, String message,
                                   DialogInterface.OnClickListener positiveListener,
                                   DialogInterface.OnClickListener negativeListener) {

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.action_dialog_yes, positiveListener)
                .setNegativeButton(R.string.action_dialog_no, negativeListener)
                .create().show();
    }

    protected void showAlertDialog(int title, int message,
                                   DialogInterface.OnClickListener positiveListener,
                                   DialogInterface.OnClickListener negativeListener) {

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.action_dialog_yes, positiveListener)
                .setNegativeButton(R.string.action_dialog_no, negativeListener)
                .create().show();
    }

    protected void showAlertDialog(int title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.action_dialog_ok, null)
                .create().show();
    }

    protected void showAlertDialog(int title, int message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.action_dialog_ok, null)
                .create().show();
    }

    protected void showAlertDialogToFinish(int title, int message) {
        showAlertDialog(title, getResources().getString(message), false, (dialog, which) -> finish());
    }

    protected void showAlertDialogToFinish(int title, String message) {
        showAlertDialog(title, message, false, (dialog, which) -> finish());
    }

    protected void showAlertDialogToFinishAndRefresh(int title, int message) {
        showAlertDialog(title, message, false, (dialog, which) -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(BundleKeys.COMMAND, BundleKeys.Commands.REFRESH);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    protected void showAlertDialogToFinishAndRefresh(int title, String message) {
        showAlertDialog(title, message, (dialog, which) -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(BundleKeys.COMMAND, BundleKeys.Commands.REFRESH);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    protected void stopProgressDialog() {
        progressDialogCount--;
        if (progressDialogCount == 0 && this.progressDialog != null && this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    protected void setVisibility(View view, int visibility) {
        view.setVisibility(visibility);
    }

    protected void setVisibility(View view, boolean visibility) {
        setVisibility(view, visibility ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                if (Utils.equals(bundle.getString(BundleKeys.COMMAND), BundleKeys.Commands.REFRESH)) {
                    initRequest();
                }
            }
        }
    }
}
