package com.chatspry.test;

import com.chatspry.Client;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Basic tests for {@link com.chatspry.Client}
 *
 * @author berwyn@chatspry.com
 */
@RunWith(JUnit4.class)
public class ClientTest {

    private Client client;

    @Before
    public void beforeEach() {
        client = new Client();
    }

}
