package com.nammapustaka.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B\'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0014\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/nammapustaka/adapter/TransactionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/nammapustaka/adapter/TransactionAdapter$Holder;", "showStudent", "", "onReturn", "Lkotlin/Function1;", "Lcom/nammapustaka/data/dao/TransactionDetail;", "", "(ZLkotlin/jvm/functions/Function1;)V", "items", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submit", "list", "", "Holder", "app_debug"})
public final class TransactionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.nammapustaka.adapter.TransactionAdapter.Holder> {
    private final boolean showStudent = false;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function1<com.nammapustaka.data.dao.TransactionDetail, kotlin.Unit> onReturn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.nammapustaka.data.dao.TransactionDetail> items = null;
    
    public TransactionAdapter(boolean showStudent, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.nammapustaka.data.dao.TransactionDetail, kotlin.Unit> onReturn) {
        super();
    }
    
    public final void submit(@org.jetbrains.annotations.NotNull()
    java.util.List<com.nammapustaka.data.dao.TransactionDetail> list) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.nammapustaka.adapter.TransactionAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.adapter.TransactionAdapter.Holder holder, int position) {
    }
    
    public TransactionAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/nammapustaka/adapter/TransactionAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/nammapustaka/databinding/ItemTransactionBinding;", "(Lcom/nammapustaka/adapter/TransactionAdapter;Lcom/nammapustaka/databinding/ItemTransactionBinding;)V", "bind", "", "item", "Lcom/nammapustaka/data/dao/TransactionDetail;", "app_debug"})
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.nammapustaka.databinding.ItemTransactionBinding binding = null;
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.nammapustaka.databinding.ItemTransactionBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.nammapustaka.data.dao.TransactionDetail item) {
        }
    }
}