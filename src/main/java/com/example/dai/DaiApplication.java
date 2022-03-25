package com.example.dai;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;

@SpringBootApplication()
public class DaiApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(DaiApplication.class, args);
    }

    public static String listFolderStructure(String username, String password, String host, int port, String command) throws Exception {
        Session session = null;
        ChannelExec channel = null;
        String response = null;
        try {
            session = new JSch().getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errorResponseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.setErrStream(errorResponseStream);
            channel.connect();
            while (channel.isConnected()) {
                Thread.sleep(100);
            }
            String errorResponse = new String(errorResponseStream.toByteArray());
            response = new String(responseStream.toByteArray());
            if(!errorResponse.isEmpty()) {
                throw new Exception(errorResponse);
            }
        } finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
        return response;
    }

}
