package juego;



public class Usuario {
	private String nombre;
	private String nick;
    private String email;
    private String dni;
    private String pass;
    private String tipo;
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Usuario()
	{
		nombre="campanella";
		nick="DEUSETVOULT";
		email="guerraelectronicacampanella@gmail.com";
		dni="48578278d";
		pass="234gt5";
		tipo=" ";
	}
	public Usuario(Usuario usuario)
	{
		this.nombre=usuario.nombre;
		this.nick=usuario.nick;
		this.dni=usuario.dni;
		this.pass=usuario.pass;
		this.tipo=usuario.tipo;
		this.email=usuario.email;
		
	}
	public Usuario(String nombre,String nick,String dni,String pass,String tipo,String email){
		this.nombre=nombre;
		this.nick=nick;
		this.pass=pass;
		this.tipo=tipo;
		this.dni=dni;
		this.email=email;
	}
	public void visualizar() {
		System.out.println("el nombre es "+nombre);
		System.out.println("nick"+nick);
		System.out.println("el password :"+pass);
		System.out.println("el dni "+dni);
		System.out.println("email"+email);
		System.out.println("el tipo es :"+tipo);
	}
	public boolean esIgual(Usuario usuario)
	{
		boolean salida=false;
		if(this.nombre.equals(usuario.getNombre())&&this.dni.equals(usuario.getDni())&&this.nick.equals(usuario.getNick())&&this.email.equals(usuario.getEmail())
				&&this.pass.equals(usuario.getPass())&&this.tipo.equals(usuario.getTipo())) {
		salida=true;
		}
		return salida;
	}
	

}
