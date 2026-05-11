package com.nammapustaka.ui.students;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/nammapustaka/ui/students/StudentsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/nammapustaka/adapter/StudentListAdapter;", "all", "", "Lcom/nammapustaka/data/entity/StudentEntity;", "binding", "Lcom/nammapustaka/databinding/FragmentStudentsBinding;", "vm", "Lcom/nammapustaka/ui/students/StudentViewModel;", "getVm", "()Lcom/nammapustaka/ui/students/StudentViewModel;", "vm$delegate", "Lkotlin/Lazy;", "filter", "", "query", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class StudentsFragment extends androidx.fragment.app.Fragment {
    private com.nammapustaka.databinding.FragmentStudentsBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy vm$delegate = null;
    private com.nammapustaka.adapter.StudentListAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.nammapustaka.data.entity.StudentEntity> all;
    
    public StudentsFragment() {
        super();
    }
    
    private final com.nammapustaka.ui.students.StudentViewModel getVm() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void filter(java.lang.String query) {
    }
}