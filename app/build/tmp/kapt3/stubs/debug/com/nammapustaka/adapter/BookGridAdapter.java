package com.nammapustaka.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0014\u0010\u0018\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/nammapustaka/adapter/BookGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/nammapustaka/adapter/BookGridAdapter$Holder;", "role", "", "onClick", "Lkotlin/Function1;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "items", "", "Lcom/nammapustaka/data/dao/BookBorrowInfo;", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "pill", "Landroid/graphics/drawable/GradientDrawable;", "color", "submit", "list", "", "Holder", "app_debug"})
public final class BookGridAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.nammapustaka.adapter.BookGridAdapter.Holder> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String role = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onClick = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.nammapustaka.data.dao.BookBorrowInfo> items = null;
    
    public BookGridAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onClick) {
        super();
    }
    
    public final void submit(@org.jetbrains.annotations.NotNull()
    java.util.List<com.nammapustaka.data.dao.BookBorrowInfo> list) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.nammapustaka.adapter.BookGridAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.adapter.BookGridAdapter.Holder holder, int position) {
    }
    
    private final android.graphics.drawable.GradientDrawable pill(java.lang.String color) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/nammapustaka/adapter/BookGridAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/nammapustaka/databinding/ItemBookGridBinding;", "(Lcom/nammapustaka/adapter/BookGridAdapter;Lcom/nammapustaka/databinding/ItemBookGridBinding;)V", "bind", "", "book", "Lcom/nammapustaka/data/dao/BookBorrowInfo;", "app_debug"})
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.nammapustaka.databinding.ItemBookGridBinding binding = null;
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.nammapustaka.databinding.ItemBookGridBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.nammapustaka.data.dao.BookBorrowInfo book) {
        }
    }
}