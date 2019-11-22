package ru.job4j.io.server;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {

    private void testClient(String in, String out) throws IOException {
        InputStream stdIn = System.in;
        Socket socket =  mock(Socket.class);
        ByteArrayInputStream baisConsole = new ByteArrayInputStream(out.getBytes());
        System.setIn(baisConsole);
        ByteArrayOutputStream baosToServer = new ByteArrayOutputStream();
        ByteArrayInputStream baisToClient = new ByteArrayInputStream(in.getBytes());
        when(socket.getInputStream()).thenReturn(baisToClient);
        when(socket.getOutputStream()).thenReturn(baosToServer);
        Client client = new Client(socket);
        client.startClient();
        assertThat(baosToServer.toString(), is(out));
        System.setIn(stdIn);
    }
    @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        testClient(String.format("%s%n%n", "GoodBye, my friend!"), String.format("%s%n", "bye"));

    }

    @Test
    public void whenSayHelloThenGreatOracle() throws IOException {
        testClient(String.format("%s%n%n%s%n%n", "Hello, dear friend, I'm a oracle.", "GoodBye, my friend!"),
                String.format("%s%n%s%n", "hello oracle", "See you"));
    }

    @Test
    public void whenUnsupportedThenDidYouMean() throws IOException {
        testClient(String.format("%s%n%n%s%n%n", "What did you mean?", "GoodBye, my friend!"),
                String.format("%s%n%s%n", "unsupported", "See you"));
    }
}