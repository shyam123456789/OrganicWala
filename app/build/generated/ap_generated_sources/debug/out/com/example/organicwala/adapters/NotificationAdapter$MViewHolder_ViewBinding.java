// Generated code from Butter Knife. Do not modify!
package com.example.organicwala.adapters;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.organicwala.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationAdapter$MViewHolder_ViewBinding implements Unbinder {
  private NotificationAdapter.MViewHolder target;

  @UiThread
  public NotificationAdapter$MViewHolder_ViewBinding(NotificationAdapter.MViewHolder target,
      View source) {
    this.target = target;

    target.ll_root = Utils.findRequiredViewAsType(source, R.id.ll_root, "field 'll_root'", LinearLayoutCompat.class);
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", AppCompatTextView.class);
    target.tv_des = Utils.findRequiredViewAsType(source, R.id.tv_des, "field 'tv_des'", AppCompatTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationAdapter.MViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ll_root = null;
    target.tv_title = null;
    target.tv_des = null;
  }
}
