package io.github.synfirecloud.jt.dubbo.provider;

import io.github.synfirecloud.jt.dubbo.core.Test;

/**
 * Created by synFireCloud on 7/11/16.
 */
public class TestImpl implements Test {
	public int p(String s) {
		System.out.println(s);
		return s.length();
	}
}
