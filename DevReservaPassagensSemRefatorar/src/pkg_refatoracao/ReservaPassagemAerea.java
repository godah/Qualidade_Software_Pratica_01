package pkg_refatoracao;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReservaPassagemAerea {
	static int opcao, opcao1, opcao2;
	static String sopcao;
	static int voo[];
	static String origem[];
	static String destino[];
	static int lugares[];
	static String dadosDeEntradaDosVoosCadastradosNoPrograma = "";

	public static void main(String[] args) {
		// Cria os vetores (N�O CONSIDERE ESSA PARTE DO C�DIGO)
		voo = new int[3];
		origem = new String[3];
		destino = new String[3];
		lugares = new int[3];
		// Carrega vetores (N�O CONSIDERE ESSA PARTE DO C�DIGO)
		voo[0] = 1;
		origem[0] = "BHTE";
		destino[0] = "S�O PAULO";
		lugares[0] = 20;
		dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[0] + "\t"
				+ origem[0] + "\t" + destino[0] + "\t" + lugares[0];
		voo[1] = 2;
		origem[1] = "S�O PAULO";
		destino[1] = "CURITIBA";
		lugares[1] = 25;
		dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[1] + "\t"
				+ origem[1] + "\t" + destino[1] + "\t" + lugares[1];
		voo[2] = 3;
		origem[2] = "CURITIBA";
		destino[2] = "JOINVILLE";
		lugares[2] = 15;
		dadosDeEntradaDosVoosCadastradosNoPrograma = dadosDeEntradaDosVoosCadastradosNoPrograma + "\n" + voo[2] + "\t"
				+ origem[2] + "\t" + destino[2] + "\t" + lugares[2];
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja verificar dados?", "Confirma��o do programa",
				JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			JTextArea saida = new JTextArea(10, 40);
			saida.setText("Nro\tOrigem\tDestino\tPassageiros");
			saida.append(dadosDeEntradaDosVoosCadastradosNoPrograma);
			JScrollPane scroll = new JScrollPane(saida);
			JOptionPane.showMessageDialog(null, scroll, "Dados dos v�os: ", JOptionPane.INFORMATION_MESSAGE);
		}
		while (true) {
			try {
				opcao1 = Integer.parseInt(
						JOptionPane.showInputDialog("OP��ES\n\n" + "1 - Consulta\n2 - Reservar\n3 - Finalizar\n\n"));
				if (opcao1 == 1) {
					while (true) {
						try {
							opcao2 = Integer.parseInt(JOptionPane.showInputDialog("CONSULTAR V�OS \n\n"
									+ "1 - Por  n�mero  do  v�o\n2 - Por  Origem\n3 - Por Destino\n4 - Consulta Geral\n5 - Voltar\n\n"));
							if (opcao2 == 1) {
								opcao = Integer.parseInt(JOptionPane.showInputDialog(
										"CONSULTAR V�O POR N�MERO DO V�O\n\n" + "Informe o n�mero do v�o"));
								if (opcao < 1 || opcao > 3) {
									JOptionPane.showMessageDialog(null, "N�mero do v�o Inexistente");
								} else {
									for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
										if (voo[variavelFor] == (opcao)) {
											String resultado = "V�o: " + voo[variavelFor] + "\n" + "Origem: "
													+ origem[variavelFor] + "\n" + "Destino: " + destino[variavelFor]
													+ "\n" + "Lugares: " + lugares[variavelFor];
											JOptionPane.showMessageDialog(null, resultado);
										}
									}
								}
							}
							if (opcao2 == 2) {
								sopcao = JOptionPane
										.showInputDialog("CONSULTAR V�O POR ORIGEM DO V�O\n\n" + "Informe a origem");
								Boolean verOrigem = true;
								verOrigem = verVPO(sopcao);
								if (verOrigem == false) {
									JOptionPane.showMessageDialog(null, "Origem n�o cadastrada no programa. Verifique",
											"Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
								} else {
									for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
										if (origem[variavelFor].equalsIgnoreCase(sopcao)) {
											String resultado = "V�o: " + voo[variavelFor] + "\n" + "Origem: "
													+ origem[variavelFor] + "\n" + "Destino: " + destino[variavelFor]
													+ "\n" + "Lugares: " + lugares[variavelFor];
											JOptionPane.showMessageDialog(null, resultado);
										}
									}
								}
							}
							if (opcao2 == 3) {
								sopcao = JOptionPane
										.showInputDialog("CONSULTAR V�O POR DESTINO DO V�O\n\n" + "Informe a origem");
								Boolean verDestino = true;
								verDestino = verVPD(sopcao);
								if (verDestino == false) {
									JOptionPane.showMessageDialog(null, "Origem n�o cadastrada no programa. Verifique",
											"Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
								} else {
									for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
										if (destino[variavelFor].equalsIgnoreCase(sopcao)) {
											String resultado = "V�o: " + voo[variavelFor] + "\n" + "Origem: "
													+ origem[variavelFor] + "\n" + "Destino: " + destino[variavelFor]
													+ "\n" + "Lugares: " + lugares[variavelFor];
											JOptionPane.showMessageDialog(null, resultado);
										}
									}
								}
							}
							if (opcao2 == 4) {
								JTextArea saida = new JTextArea(10, 40);
								saida.setText("Nro\tOrigem\tDestino\tPassageiros");
								saida.append(dadosDeEntradaDosVoosCadastradosNoPrograma);
								JScrollPane scroll = new JScrollPane(saida);
								JOptionPane.showMessageDialog(null, scroll, "Dados dos v�os: ",
										JOptionPane.INFORMATION_MESSAGE);
							}
							if (opcao2 == 5) {
								break;
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa ser� finalizado");
							break;
						}
					}
				}
				if (opcao1 == 2) {
					JOptionPane.showMessageDialog(null, "OP��O 2 - RESERVA \nOp��o em desenvolvimento ...");
				}
				if (opcao1 == 3) {
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa ser� finalizado");
				break;
			}
		}
		System.out.println("\n\nPROGRAMA FINALIZADO!");
	}
	// main
	// VERIFICA SE H� V�O PARA A ORIGEM INFORMADA PELO USU�RIO
	// OU SEJA: VERVPO (VERIFICA V�O POR ORIGEM) O PAR�METRO
	// ARGS � O NOME DA CIDADE DE ORIGEM. ENTENDEU?

	private static Boolean verVPO(String args) {
		for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
			if (origem[variavelFor].equalsIgnoreCase(sopcao)) {
				return true;
			}
		}
		return false;
	}
	// VERIFICA SE H� V�O PARA O DESTINO INFORMADO PELO USU�RIO
	// OU SEJA: VERVPD (VERIFICA V�O POR DESTINO) O PAR�METRO
	// ARGS � O NOME DA CIDADE DE DESTINO. ENTENDEU?

	private static Boolean verVPD(String args) {
		for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
			if (destino[variavelFor].equalsIgnoreCase(sopcao)) {
				return true;
			}
		}
		return false;
	}
}