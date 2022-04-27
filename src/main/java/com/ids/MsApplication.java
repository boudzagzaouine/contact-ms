package com.ids;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ids.data.utils.ApplicationStarter;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MsApplication {

	public static void main(String[] args) {
		ApplicationStarter.Main(args, MsApplication.class);
	}
}
