public class Cliente{
	private String codigo;
	private String name;
	public Cliente(String cod,String n) {
		codigo=cod;
		name=n;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
