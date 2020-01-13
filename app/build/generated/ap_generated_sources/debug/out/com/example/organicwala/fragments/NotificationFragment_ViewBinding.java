// Generated code from Butter Knife. Do not modify!
package com.example.organicwala.fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.organicwala.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationFragment_ViewBinding implements Unbinder {
  private NotificationFragment target;

  @UiThread
  public NotificationFragment_ViewBinding(NotificationFragment target, View source) {
    this.target = target;

    target.rv_notification = Utils.findRequiredViewAsType(source, R.id.rv_notification, "field 'rv_notification'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_notification = null;
  }
}
