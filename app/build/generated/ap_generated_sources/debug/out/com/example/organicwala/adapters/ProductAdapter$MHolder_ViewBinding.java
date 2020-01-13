// Generated code from Butter Knife. Do not modify!
package com.example.organicwala.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.organicwala.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductAdapter$MHolder_ViewBinding implements Unbinder {
  private ProductAdapter.MHolder target;

  @UiThread
  public ProductAdapter$MHolder_ViewBinding(ProductAdapter.MHolder target, View source) {
    this.target = target;

    target.menu_img = Utils.findRequiredViewAsType(source, R.id.menu_img, "field 'menu_img'", ImageView.class);
    target.root = Utils.findRequiredViewAsType(source, R.id.root, "field 'root'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductAdapter.MHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.menu_img = null;
    target.root = null;
  }
}
