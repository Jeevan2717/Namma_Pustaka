package com.nammapustaka.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/nammapustaka/adapter/StudentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/nammapustaka/adapter/StudentListAdapter$Holder;", "onClick", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "Lcom/nammapustaka/data/entity/StudentEntity;", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submit", "list", "", "Holder", "app_debug"})
public final class StudentListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.nammapustaka.adapter.StudentListAdapter.Holder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onClick = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.nammapustaka.data.entity.StudentEntity> items = null;
    
    public StudentListAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onClick) {
        super();
    }
    
    public final void submit(@org.jetbrains.annotations.NotNull()
    java.util.List<com.nammapustaka.data.entity.StudentEntity> list) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.nammapustaka.adapter.StudentListAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.adapter.StudentListAdapter.Holder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/nammapustaka/adapter/StudentListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/nammapustaka/databinding/ItemStudentBinding;", "(Lcom/nammapustaka/adapter/StudentListAdapter;Lcom/nammapustaka/databinding/ItemStudentBinding;)V", "bind", "", "student", "Lcom/nammapustaka/data/entity/StudentEntity;", "app_debug"})
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.nammapustaka.databinding.ItemStudentBinding binding = null;
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.nammapustaka.databinding.ItemStudentBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.nammapustaka.data.entity.StudentEntity student) {
        }
    }
}