package es.happ.server.types;

public enum TypeGroup {
	
	A, // Text A and Video A
	
	B, // Text A and Video B
	
	C, // Text A and no Video
	
	D; // Text B and no Video

	
	public static boolean showVideo(String codeGroup) {
		boolean salida = false;
		
		if (A.name().equals(codeGroup)) {
			salida = true;
		} else if (B.name().equals(codeGroup)) {
			salida = true;
		}
		return salida;
	}
}
