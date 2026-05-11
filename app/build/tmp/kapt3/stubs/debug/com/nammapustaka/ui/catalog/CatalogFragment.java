package com.nammapustaka.ui.catalog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/nammapustaka/ui/catalog/CatalogFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/nammapustaka/adapter/BookGridAdapter;", "all", "", "Lcom/nammapustaka/data/dao/BookBorrowInfo;", "binding", "Lcom/nammapustaka/databinding/FragmentCatalogBinding;", "category", "", "query", "vm", "Lcom/nammapustaka/ui/catalog/CatalogViewModel;", "getVm", "()Lcom/nammapustaka/ui/catalog/CatalogViewModel;", "vm$delegate", "Lkotlin/Lazy;", "filter", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class CatalogFragment extends androidx.fragment.app.Fragment {
    private com.nammapustaka.databinding.FragmentCatalogBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy vm$delegate = null;
    private com.nammapustaka.adapter.BookGridAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.nammapustaka.data.dao.BookBorrowInfo> all;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String query = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String category = "All";
    
    public CatalogFragment() {
        super();
    }
    
    private final com.nammapustaka.ui.catalog.CatalogViewModel getVm() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void filter() {
    }
}