package br.com.mariobacellar.geradordocid.util;

public class CPFHandler {

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
			int digdv1 = (int) (Math.random() * ((max - min) + 1)) + min;
			int digdv2 = (int) (Math.random() * ((max - min) + 1)) + min;

			int dvERRADO = calculaCPFDV_ERRADO(dig001, dig002, dig003, dig004, dig005, dig006, dig007, dig008, dig009);

			String cpf = "" + dig001 + dig002 + dig003 + dig004 + dig005 + dig006 + dig007 + dig008 + dig009 + dvERRADO;
			String cpf_fmt = "" + dig001 + dig002 + dig003 + "." + dig004 + dig005 + dig006 + "." + dig007 + dig008 + dig009 + "-" + dvERRADO;

//			System.out.println("CPF:["+cpf+"]");
//			System.out.println("CPF FMT:["+cpf_fmt+"]");

			String[] ret = new String[] { cpf, cpf_fmt };
			return ret;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int calculaCPFDV_ERRADO(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9)
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
		if (dv1 >= 10)
			dv1 = 0;

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
		if (dv2 >= 10)
			dv2 = 0;

		String ret = "" + dv1 + dv2;
		int iret = Integer.parseInt(ret);

		// para retornar ERRADO
		if (iret == 0)
			iret = 1;
		else if (iret > 0)
			iret--;

		return iret;
	}

	public static void main(String[] args) {
		try {
			String[] resp = CPFHandler.generateCPF();
			System.out.println("CPF:[" + resp[0] + "]");
			System.out.println("CPF FMT:[" + resp[1] + "]");

			String dverrado = "" + CPFHandler.calculaCPFDV_ERRADO(0, 1, 5, 0, 6, 5, 6, 3, 7);
			System.out.println("dverrado:[" + dverrado + "]");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
