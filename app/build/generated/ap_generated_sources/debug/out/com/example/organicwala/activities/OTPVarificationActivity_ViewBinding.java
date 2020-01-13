// Generated code from Butter Knife. Do not modify!
package com.example.organicwala.activities;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.alahammad.otp_view.OtpView;
import com.example.organicwala.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OTPVarificationActivity_ViewBinding implements Unbinder {
  private OTPVarificationActivity target;

  @UiThread
  public OTPVarificationActivity_ViewBinding(OTPVarificationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OTPVarificationActivity_ViewBinding(OTPVarificationActivity target, View source) {
    this.target = target;

    target.otpView = Utils.findRequiredViewAsType(source, R.id.otp, "field 'otpView'", OtpView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OTPVarificationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.otpView = null;
  }
}
