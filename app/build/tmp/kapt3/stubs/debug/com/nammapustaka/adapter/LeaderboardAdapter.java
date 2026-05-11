package com.nammapustaka.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/nammapustaka/adapter/LeaderboardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/nammapustaka/adapter/LeaderboardAdapter$Holder;", "()V", "items", "", "Lcom/nammapustaka/data/entity/StudentEntity;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submit", "list", "", "Holder", "app_debug"})
public final class LeaderboardAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.nammapustaka.adapter.LeaderboardAdapter.Holder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.nammapustaka.data.entity.StudentEntity> items = null;
    
    public LeaderboardAdapter() {
        super();
    }
    
    public final void submit(@org.jetbrains.annotations.NotNull()
    java.util.List<com.nammapustaka.data.entity.StudentEntity> list) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.nammapustaka.adapter.LeaderboardAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.adapter.LeaderboardAdapter.Holder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/nammapustaka/adapter/LeaderboardAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/nammapustaka/databinding/ItemLeaderboardBinding;", "(Lcom/nammapustaka/databinding/ItemLeaderboardBinding;)V", "bind", "", "student", "Lcom/nammapustaka/data/entity/StudentEntity;", "rank", "", "app_debug"})
    public static final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.nammapustaka.databinding.ItemLeaderboardBinding binding = null;
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.nammapustaka.databinding.ItemLeaderboardBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.nammapustaka.data.entity.StudentEntity student, int rank) {
        }
    }
}