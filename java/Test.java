package com.java.RSA;

import java.math.BigInteger;
import java.net.URLDecoder;

public class Test {

	public static void main(String[] args) throws Exception {
		String pwd;
		//前端传输至后台的密文，这里是我测试的数据，请改成自己测试时前端页面生成的result结果
		String result = "1480ed9f7d4f8999f3b1a13f87e3c220534bbf7b7618671ff66c0d34224fca0d19d58a183f558be967cecdcb6b20a6c80b83efde59a3ea05254eff05d7038b75ee5ba4b543a427b4b3560d06d900f4c7349d166bb60a1636c5a48f4bdfface3d4e7bc8073e76b2c87ad6fd18592f87216eb014eea9ae39ae3ef1c08f0416af0e";
		System.out.println("原文加密后为：");
		System.out.println(result);
		byte[] en_result = new BigInteger(result, 16).toByteArray();
		//如果上述方法报错
		//byte[] en_result = RSAUtil.hexStringToBytes(result);
		// System.out.println("转成byte[]" + new String(en_result));
		byte[] de_result = RSAUtil.decrypt(RSAUtil.getKeyPair().getPrivate(), en_result);
		System.out.println("还原密文：");
		System.out.println(new String(de_result));
		StringBuffer sb = new StringBuffer();
		sb.append(new String(de_result));
		pwd = sb.reverse().toString();//字符串反转操作，因为一开始解密的结果是倒过来的
		System.out.println(sb);
		System.out.println("=================================");
		pwd = URLDecoder.decode(pwd, "UTF-8");//
		System.out.println(pwd);
	}
}
