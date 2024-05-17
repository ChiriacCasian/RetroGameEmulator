package com.gameTutorial.gameApp;

import java.io.*;
import java.lang.ProcessBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class CommitSchedulerLauncher {
    private static String remoteBranchName ;
    private static String localBranchName ;
    private static String pat_token ;
    private static String ssh_key ;
    public static void main(String[] args) throws IOException {
        getProperties() ;
        checkProtocol() ;
        String freshestCommit ;
        String oldestCommit ;
        oldestCommit = getOldestUnpushedCommit();
        freshestCommit = getFreshestCommit();
        if(freshestCommit == null || oldestCommit == null){
            System.out.println("Nothing to push, branch up to date");
            return ;
        }
        setHeadToSha1(getOldestUnpushedCommit());
        push() ;
        setHeadToSha1(freshestCommit);
    }

    private static void checkProtocol() throws IOException { /// nothing again fdsagdsasdag
        ProcessBuilder processBuilder = new ProcessBuilder();
        List<String> command = Arrays.asList("git", "config", "--get", "remote."+remoteBranchName +".url") ;

        processBuilder.command(command) ;
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String remoteLink = reader.readLine() ;
        if(remoteLink.startsWith("https://github.com")){
            /// either switch to ssh, or use PAT token to authenticate http remote communication
            /// if PAT token is provided in the properties file, use it to authenticate
            if(pat_token == null){
                System.out.println("You are using http protocol but no authentication token provided, exiting");
                System.out.println("Please provide a PAT token in the application.properties file, or switch to ssh protocol");
                return ;
            }
            /// pat token migh still be wrong, or not have the required permissions
            if(ssh_key != null){
                connectToSsh() ;
                return;
            }
            connectToHttp(remoteLink);
        }
        /// they are using ssh so everything is fine
        return ;
    }
    private static void connectToSsh() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        List<String> command = Arrays.asList("git", "remote", "set-url", remoteBranchName, ssh_key) ;
        processBuilder.command(command).start() ;
    }
    private static void connectToHttp(String remoteLink) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        List<String> command = Arrays.asList("git", "remote", "set-url", remoteBranchName, remoteLink.replace("https://", "https://"+pat_token+"@")) ;
        processBuilder.command(command).start() ;
    }

    private static void getProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/main/resources/application.properties");
        properties.load(in);
        in.close();
        remoteBranchName = properties.getProperty("remote_branch_name");
        localBranchName = properties.getProperty("local_branch_name");
        pat_token = properties.getProperty("PAT_token");
        ssh_key = properties.getProperty("ssh_key");
    }
    private static void push() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        List<String> command = Arrays.asList("git", "push", remoteBranchName, localBranchName) ;
        processBuilder.command(command).start() ;
    }
    private static String getOldestUnpushedCommit() throws IOException {
        //git log origin/main..main --pretty=format:"%H %s"
        ProcessBuilder processBuilder = new ProcessBuilder();
        List<String> command = Arrays.asList("git", "log", remoteBranchName + "/" + localBranchName + ".." +
                localBranchName, "--pretty=format:%H");
        processBuilder.command(command) ;
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "" ;
        String rez = null ;
        while((line = reader.readLine()) != null){
            rez = line ;
        }
        return rez ;
    }
    private static String getFreshestCommit() throws IOException {
        //git log origin/main..main --pretty=format:"%H %s"
        ProcessBuilder processBuilder = new ProcessBuilder();
        List<String> command = Arrays.asList("git", "log", remoteBranchName + "/" + localBranchName + ".." +
                localBranchName, "--pretty=format:%H");
        processBuilder.command(command) ;
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        return reader.readLine() ;
    }
    private static void setHeadToSha1(String sha1) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        List<String> command = Arrays.asList("git", "reset", "--soft", sha1) ;
        processBuilder.command(command).start() ;
    }
}