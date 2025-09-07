package com.jivaansh.biometricattendance.biometric;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004Jt\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u000e2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00060\u000eJ\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/jivaansh/biometricattendance/biometric/BiometricHelper;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "authenticateWithBiometric", "", "title", "", "subtitle", "negativeText", "cipher", "Ljavax/crypto/Cipher;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resultCipher", "onError", "reason", "canAuthenticate", "", "generateBiometricKey", "alias", "getCipherForAlias", "app_debug"})
public final class BiometricHelper {
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity activity = null;
    
    public BiometricHelper(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity activity) {
        super();
    }
    
    public final boolean canAuthenticate() {
        return false;
    }
    
    public final void generateBiometricKey(@org.jetbrains.annotations.NotNull
    java.lang.String alias) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final javax.crypto.Cipher getCipherForAlias(@org.jetbrains.annotations.NotNull
    java.lang.String alias) {
        return null;
    }
    
    public final void authenticateWithBiometric(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String subtitle, @org.jetbrains.annotations.NotNull
    java.lang.String negativeText, @org.jetbrains.annotations.Nullable
    javax.crypto.Cipher cipher, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super javax.crypto.Cipher, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
}