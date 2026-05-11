package com.nammapustaka.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u001a\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J \u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006$"}, d2 = {"Lcom/nammapustaka/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/nammapustaka/adapter/BookGridAdapter;", "binding", "Lcom/nammapustaka/databinding/FragmentHomeBinding;", "vm", "Lcom/nammapustaka/ui/home/HomeViewModel;", "getVm", "()Lcom/nammapustaka/ui/home/HomeViewModel;", "vm$delegate", "Lkotlin/Lazy;", "addActions", "", "role", "", "addChips", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "renderStats", "books", "", "Lcom/nammapustaka/data/dao/BookBorrowInfo;", "sectionTitle", "Landroid/widget/TextView;", "textValue", "statView", "label", "value", "", "danger", "", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private com.nammapustaka.databinding.FragmentHomeBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy vm$delegate = null;
    private com.nammapustaka.adapter.BookGridAdapter adapter;
    
    public HomeFragment() {
        super();
    }
    
    private final com.nammapustaka.ui.home.HomeViewModel getVm() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void addActions(java.lang.String role) {
    }
    
    private final void addChips() {
    }
    
    private final void renderStats(java.lang.String role, java.util.List<com.nammapustaka.data.dao.BookBorrowInfo> books) {
    }
    
    private final android.widget.TextView statView(java.lang.String label, int value, boolean danger) {
        return null;
    }
    
    private final android.widget.TextView sectionTitle(java.lang.String textValue) {
        return null;
    }
}