package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.PayementMode;

@TransactionalService
public class PayementModeService extends AbstractService<PayementMode, UUID> {

	public List<PayementMode> init() throws Exception {
		List<PayementMode> payementModes = new ArrayList<>();
		File f = new File("src/main/resources/init/mode_paiement.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String line = sc.nextLine().trim();
			String[] blocks = line.split("##");
			PayementMode payementMode = new PayementMode();
			payementMode.setDesign(blocks[0]);
			payementMode.setCode(blocks[1]);
			payementModes.add(payementMode);
		}
		sc.close();
		return payementModes;

	}
}
