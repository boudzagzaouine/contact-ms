package com.ids;

public class Gener {
	public static void main(String[] args) {
		String[] ents = new String[] { "Fournisseur", "CommandesFournisseur", "MatierePremiere", "LigneDeCommande" };
		for (String e : ents) {
			System.out.println(gen(e));
			System.out.println("""
					/********************************************/
					""");
		}
	}

	public static String gen(String in) {
		return "export interface " + in + "Json{\r\n" + "content:" + in + "[]\r\n" + "}\r\n" + "export type Open" + in
				+ "Prop = {\r\n" + "  data: " + in + "Json;\r\n" + "  refetch: () => void;\r\n"
				+ "  save: () => void;\r\n" + "  edit: () => void;\r\n" + "};\r\n" + "export const open" + in
				+ "s = (): Open" + in + "Prop => {\r\n" + "  const { data = [], refetch } = useFetch" + in
				+ "sQuery();\r\n" + "  const [save] = useAdd" + in + "Mutation();\r\n" + "  const [edit] = useEdit" + in
				+ "Mutation();\r\n" + "  //@ts-ignore\r\n" + "  const out: Open" + in
				+ "Prop = { data, refetch, save, edit };\r\n" + "  return out;\r\n" + "};";
	}
}
