package claro.flex.utils;

public class GetExcel {
    private final String usuario;
    private final String senha;

    public GetExcel(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
