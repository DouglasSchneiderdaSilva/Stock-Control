import java.util.Scanner;
public class Estoque {
	public static String cadastrarProduto(String matriz [][], String codigo, String descricao, String quant, String preco) {
		for(int i = 0; i < 10; i++) {
			if (matriz[i][0].equals(codigo)) {
				return "0";
			}else if(matriz[i][0].equals("")) {
				matriz[i][0] = codigo;
				matriz[i][1] = descricao;
				matriz[i][2] = quant;
				matriz[i][3] = preco;
				return "1";
			} 
			
		}
		return "-1";
	}
	public static String excluirProduto(String matriz [][], String codigo) {
		
		for (int i = 0; i < 10; i++) {
			if(matriz [i][0].equals(codigo)){
				for(int j = 0; j < 4; j++) {
					matriz[i][j] = "";
				}
				return "1";
			}
		}
		return "-1";
	}
	public static String venderProdutos(String matriz[][], String codigo, String quant) {
		int quantidade = Integer.parseInt(quant);
		for (int i = 0; i < 10; i++) {
			if (matriz[i][0].equals(codigo)) {
				if (quantidade <= 0 ) {
					return"-3";
				}
				int quantFinal = Integer.parseInt(matriz [0][2]) - quantidade;
				if (quantFinal > 0 ) {
					matriz [i][2] = Integer.toString(quantFinal); 
					return "1";
				}
				if (quantFinal < 0) {
					return "-1";
				}
				
			}
		}
		return "-2";
	}
	public static void imprimirMensagem(String ordem, int resultadoInt) {
		if (ordem.equals("CADASTRAR")) {
			switch(resultadoInt) {
			
			case 1:{
				System.out.println("Produto cadastrado com sucesso.");
				break;
			}
			case 0:{
				System.out.println("ERRO: Produto já cadastrado no sistema!");
				break;
			}
			case -1: {
				System.out.println("ERRO: Não há memória disponível para realizar o cadastro!");
				break;
			}
			default: {
				System.out.println("ERRO! Parâmetros informados incorretamente!");
				break;
			}
			}
		}
		if (ordem.equals("EXCLUIR")) {
			switch(resultadoInt) {
			case 1: {
				System.out.println("Produto excluído com sucesso.");
				break;
			}
			case -1: {
				System.out.println("ERRO: Produto não existe no sistema!");
				break;
			}
			}
		}
		if(ordem.equals("VENDER")) {
			switch(resultadoInt) {
			case 1: {
				System.out.println("Venda realizada com sucesso.");
				break;
			}
			case -1: {
				System.out.println("ERRO: Não existe quantidade em estoque suficiente para a realizar a venda!");
				break;
			}
			case -2: {
				System.out.println("ERRO: Produto não cadastrado!");
				break;
			}
			case -3: {
				System.out.println("ERRO: Quantidade inválida!");
				
			}
			default: {
				System.out.println("ERRO! Parâmetros informados incorretamente!");
				break;
			}
			}
		}
	}
	public static void imprimirProdutos(String matriz[][]) {

		int i = 0;
		while(i < 10) {
			if (matriz[i][0].equals("")) {
				i++;
			}else {
				System.out.println("----------" + "\n");
				System.out.println("codigo: " + matriz[i][0] + "\n");
				System.out.println("produto: " + matriz[i][1] + "\n") ;
				System.out.println("quantidade: " + matriz[i][2] + "\n");
				System.out.println("preço: " + matriz[i][3] + "\n");
				System.out.println("----------");
				i++;
			}
		}
	}	
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		String [][] matriz = new String [10][4];
		
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = "";
			}
		}
		
	
		
		System.out.println("Escolha uma das opções aabaixo");
		System.out.println("------------------------------");
		System.out.println("    1 - Cadastrar Produto");
		System.out.println("    2 - Excluir Produto");
		System.out.println("    3 - Imprimir Produtos");
		System.out.println("    4 - Vender Produtos");
		System.out.println("------------------------------");
		System.out.println("Digite 0 caso queria cancelar o procedimento");
		
		int acao = scn.nextInt();
		
		while (acao != 0) {	
	
			switch (acao){
			case 1: {
				System.out.println("Qual o codigo do produto que você deseja cadastrar?");
				String codigo = scn.next();
				
				while (codigo.equals("0")) {
					System.out.println("O codigo do produto não pode ser 0");
					codigo = scn.next();
				}
		
				System.out.println("Qual a descrição do produto que você deseja cadastrar?");
				String descricao = scn.next(); 
				System.out.println("Qual a quantidade de produtos que você deseja cadastrar");
				String quantidade = scn.next();
				System.out.println("Qual o preço do produto que você deseja cadastrar");
				String preco = scn.next();
		
				String resultado = cadastrarProduto(matriz, codigo, descricao, quantidade, preco);
				String ordem = "CADASTRAR";
			
				int resultadoInt = Integer.parseInt(resultado);
				imprimirMensagem(ordem , resultadoInt);
				break;
			}
			case 2:{
				System.out.println("Qual o codigo do produto que você deseja exluir?");
				String codigo = scn.next();
				
				String resultado = excluirProduto(matriz, codigo);
				String ordem = "EXCLUIR";
				
				int resultadoInt = Integer.parseInt(resultado);
				imprimirMensagem(ordem, resultadoInt);
				break;
			}
			case 3: {
				imprimirProdutos(matriz);
				break;
			}
			case 4: {
				System.out.println("Qual o codigo do produto que vocÊ deseja vender?");
				String codigo = scn.next();
				System.out.println("Quantos produtos você venderá?");
				String quant = scn.next();
	
				String resultado = venderProdutos(matriz, codigo, quant);
				String ordem = "VENDER";
				
				int resultadoInt = Integer.parseInt(resultado);
				imprimirMensagem(ordem, resultadoInt);
				break;
			
			}
		
			default: { 
				System.out.println("Você digitou algo que não corresponde as ações do Menu");
				break;
			}
			}
			
			System.out.println("Escolha uma das opções abaixo");
			System.out.println("------------------------------");
			System.out.println("    1 - Cadastrar Produto");
			System.out.println("    2 - Excluir Produto");
			System.out.println("    3 - Imprimir Produtos");
			System.out.println("    4 - Vender Produtos");
			System.out.println("------------------------------");
			System.out.println("Digite 0 caso queria cancelar o procedimento");
		
			acao = scn.nextInt();
		
		} 
			scn.close();
	}
}

		
		
		


