package br.com.mariobacellar.geradordocid.util;

public class CPFCNPJHandler {

	private static final int SIZE_OF_CNPJ = 14;
	private static final int SIZE_OF_CPF = 11;
	
	public static String[] generateCNPJ() {
		try {

			int min = 0;
			int max = 9;

			int dig001 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig002 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig003 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig004 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig005 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig006 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig007 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig008 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig009 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig010 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig011 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig012 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig013 = (int) (Math.random() * ((max - min) + 1)) + min;

			String dvERRADO  = calculaCNPJ_DV_ERRADO(dig001, dig002, dig003, dig004, dig005, dig006, dig007, dig008, dig009, dig010, dig011, dig012, dig013);
			String cnpj      = ""                 + dig001+ dig002+ dig003+ dig004+ dig005+ dig006+ dig007+ dig008+ dig009+ dig010+ dig011+ dig012+ dvERRADO;
			String cnpj_fmt  = formatCnpj(cnpj); 
			String[] ret     = new String[] { cnpj, cnpj_fmt };
			return ret;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String calculaCNPJ_DV_ERRADO(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int d10, int d11, int d12, int d13) throws Exception {

		// Primeiro DV
		int xd1  = d1  * 5;
		int xd2  = d2  * 4;
		int xd3  = d3  * 3;
		int xd4  = d4  * 2;
		int xd5  = d5  * 9;
		int xd6  = d6  * 8;
		int xd7  = d7  * 7;
		int xd8  = d8  * 6;
		int xd9  = d9  * 5;
		int xd10 = d10 * 4;
		int xd11 = d11 * 3;
		int xd12 = d12 * 2;
		
		int xdv1 = xd1 + xd2 + xd3 + xd4 + xd5 + xd6 + xd7 + xd8 + xd9 + xd10+ xd11 + xd12;
		int dv1 = 11 - (xdv1 % 11);
		if (dv1 >= 10) dv1 = 0;

		// Segeundo DV
		xd1  = d1  * 6;
		xd2  = d2  * 5;
		xd3  = d3  * 4;
		xd4  = d4  * 3;
		xd5  = d5  * 2;
		xd6  = d6  * 9;
		xd7  = d7  * 8;
		xd8  = d8  * 7;
		xd9  = d9  * 6;
		xd10 = d10 * 5;
		xd11 = d11 * 4;
		xd12 = d12 * 3;
	int	xd13 = d13 * 2;
				
		int xdv2 = xd1 + xd2 + xd3 + xd4 + xd5 + xd6 + xd7 + xd8 + xd9 + xd10 + xd11 + xd12 + xd13;
		int dv2 = 11 - (xdv2 % 11);
		if (dv2 >= 10) dv2 = 0;

		String ret = "" + dv1 + dv2;
		int   iret = Integer.parseInt(ret);

		// para retornar ERRADO
		if (iret == 0) 	iret = 1; else 
		if (iret > 0 )	iret--;

		if (iret<10) ret = "0" + iret;

		return ret;
	}

	
	public static String[] generateCPF() {
		try {

			int min = 0;
			int max = 9;

			int dig001 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig002 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig003 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig004 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig005 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig006 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig007 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig008 = (int) (Math.random() * ((max - min) + 1)) + min;
			int dig009 = (int) (Math.random() * ((max - min) + 1)) + min;

			String dvERRADO = calculaCPF_DV_ERRADO(dig001, dig002, dig003, dig004, dig005, dig006, dig007, dig008, dig009);
			String cpf      = ""                + dig001+ dig002+ dig003+ dig004+ dig005+ dig006+ dig007+ dig008+ dig009 + dvERRADO;
			String cpf_fmt  = formatCpf(cpf); 
			String[] ret    = new String[] { cpf, cpf_fmt };
			return ret;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String calculaCPF_DV_ERRADO(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9)
			throws Exception {

		// Primeiro DV
		int xd1 = d1 * 10;
		int xd2 = d2 * 9;
		int xd3 = d3 * 8;
		int xd4 = d4 * 7;
		int xd5 = d5 * 6;
		int xd6 = d6 * 5;
		int xd7 = d7 * 4;
		int xd8 = d8 * 3;
		int xd9 = d9 * 2;
		int xdv1 = xd1 + xd2 + xd3 + xd4 + xd5 + xd6 + xd7 + xd8 + xd9;
		int dv1 = 11 - (xdv1 % 11);
		if (dv1 >= 10) dv1 = 0;

		// Segeundo DV
		xd1 = d1 * 11;
		xd2 = d2 * 10;
		xd3 = d3 * 9;
		xd4 = d4 * 8;
		xd5 = d5 * 7;
		xd6 = d6 * 6;
		xd7 = d7 * 5;
		xd8 = d8 * 4;
		xd9 = d9 * 3;
		int xdv = dv1 * 2;
		int xdv2 = xd1 + xd2 + xd3 + xd4 + xd5 + xd6 + xd7 + xd8 + xd9 + xdv;
		int dv2 = 11 - (xdv2 % 11);
		if (dv2 >= 10) dv2 = 0;

		String ret = "" + dv1 + dv2;
		int   iret = Integer.parseInt(ret);

		// para retornar ERRADO
		if (iret == 0) 	iret = 1; else 
		if (iret > 0 )	iret--;

		if (iret<10) ret = "0" + iret;

		return ret;
	}

	public static String formatCnpj(String cnpj) throws Exception {
		if (cnpj != null) {
			cnpj = cnpj.replaceAll("\\D", "");
			if ((cnpj.length() == SIZE_OF_CNPJ)) {
				return cnpj.replaceAll("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1\\.$2\\.$3/$4-$5");
			}
		}
		throw new Exception("Cnpj inválido.");
	}

	public static String formatCpf(String cpf) throws Exception {
		if (cpf != null) {
			cpf = cpf.replaceAll("\\D", "");
			if (cpf.length() == SIZE_OF_CPF) {
				return cpf.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1\\.$2\\.$3-$4");
			}
		}
		throw new Exception("Cpf inválido.");
	}
	

}
