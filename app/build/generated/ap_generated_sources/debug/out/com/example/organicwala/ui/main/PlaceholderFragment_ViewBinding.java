// Generated code from Butter Knife. Do not modify!
package com.example.organicwala.ui.main;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.organicwala.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlaceholderFragment_ViewBinding implements Unbinder {
  private PlaceholderFragment target;

  @UiThread
  public PlaceholderFragment_ViewBinding(PlaceholderFragment target, View source) {
    this.target = target;

    target.rv_products = Utils.findRequiredViewAsType(source, R.id.rv_products, "field 'rv_products'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlaceholderFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_products = null;
  }
}
