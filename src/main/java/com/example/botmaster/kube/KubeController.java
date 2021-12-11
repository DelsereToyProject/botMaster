package com.example.botmaster.kube;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class KubeController{

    public String uploadProcess(String bot_repo) throws IOException {
        Process process = Runtime.getRuntime().exec(
                "kubectl delete pods -l name="
                        + bot_repo +" --grace-period=30 --force");

        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        return output.toString();
    }

    public String killProcess(String bot_repo) throws IOException {
        Process process = Runtime.getRuntime().exec(
                "kubectl delete pods -l name="
                        + bot_repo +" --grace-period=30 --force");

        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        return output.toString();
    }
}
