package id.student.penjumlahansederhana.presenter;

import id.student.penjumlahansederhana.model.LuasPersegi;
import id.student.penjumlahansederhana.view.MainActivity;

public class PresenterMain {

    public InterfaceMain interfaceMain;

    public PresenterMain(InterfaceMain interfaceMain) {
        this.interfaceMain = interfaceMain;
    }

    public void hitungLuas(LuasPersegi luasPersegi){

        int hasil = luasPersegi.getLebar() * luasPersegi.getPanjang();
        LuasPersegi luasPersegiHasil = new LuasPersegi();
        luasPersegiHasil.setHasil(hasil);
        interfaceMain.hasil(luasPersegiHasil);

    }
}
