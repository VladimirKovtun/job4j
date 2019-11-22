package ru.job4j.io.server;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private void testServer(String in, String out) throws IOException {
        Socket socket =  mock(Socket.class);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bais = new ByteArrayInputStream(in.getBytes());
        when(socket.getInputStream()).thenReturn(bais);
        when(socket.getOutputStream()).thenReturn(baos);
        Server server = new Server(socket);
        server.startServer();
        assertThat(baos.toString(), is(out));
    }

    @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        testServer("bye", String.format("%s%n%n", "GoodBye, my friend!"));

    }

    @Test
    public void whenSayHelloThenGreatOracle() throws IOException {
        testServer(String.format("%s%n%s", "hello oracle", "See you"),
                String.format("%s%n%n%s%n%n", "Hello, dear friend, I'm a oracle.", "GoodBye, my friend!"));
        }

    @Test
    public void whenUnsupportedThenDidYouMean() throws IOException {
        testServer(String.format("%s%n%s", "unsupported", "See you"),
                   String.format("%s%n%n%s%n%n", "What did you mean?", "GoodBye, my friend!"));
    }
}