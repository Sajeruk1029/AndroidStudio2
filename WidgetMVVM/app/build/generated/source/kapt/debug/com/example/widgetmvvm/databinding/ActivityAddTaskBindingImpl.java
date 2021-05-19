package com.example.widgetmvvm.databinding;
import com.example.widgetmvvm.R;
import com.example.widgetmvvm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityAddTaskBindingImpl extends ActivityAddTaskBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.include, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView1;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mViewmodelTestAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mViewmodelOnAddClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityAddTaskBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityAddTaskBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.CheckBox) bindings[2]
            , (android.view.View) bindings[4]
            , (android.widget.Button) bindings[3]
            );
        this.checkbox.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.EditText) bindings[1];
        this.mboundView1.setTag(null);
        this.onAddClicked.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewmodel == variableId) {
            setViewmodel((com.example.widgetmvvm.viewmodel.DataViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.example.widgetmvvm.viewmodel.DataViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        android.text.TextWatcher viewmodelTextWatcher = null;
        android.view.View.OnClickListener viewmodelTestAndroidViewViewOnClickListener = null;
        com.example.widgetmvvm.viewmodel.DataViewModel viewmodel = mViewmodel;
        android.view.View.OnClickListener viewmodelOnAddClickedAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.TextWatcher
                    viewmodelTextWatcher = viewmodel.getTextWatcher();
                    // read viewmodel::test
                    viewmodelTestAndroidViewViewOnClickListener = (((mViewmodelTestAndroidViewViewOnClickListener == null) ? (mViewmodelTestAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewmodelTestAndroidViewViewOnClickListener).setValue(viewmodel));
                    // read viewmodel::onAddClicked
                    viewmodelOnAddClickedAndroidViewViewOnClickListener = (((mViewmodelOnAddClickedAndroidViewViewOnClickListener == null) ? (mViewmodelOnAddClickedAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mViewmodelOnAddClickedAndroidViewViewOnClickListener).setValue(viewmodel));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.checkbox.setOnClickListener(viewmodelTestAndroidViewViewOnClickListener);
            this.mboundView1.addTextChangedListener(viewmodelTextWatcher);
            this.onAddClicked.setOnClickListener(viewmodelOnAddClickedAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.example.widgetmvvm.viewmodel.DataViewModel value;
        public OnClickListenerImpl setValue(com.example.widgetmvvm.viewmodel.DataViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.test(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.example.widgetmvvm.viewmodel.DataViewModel value;
        public OnClickListenerImpl1 setValue(com.example.widgetmvvm.viewmodel.DataViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onAddClicked(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}