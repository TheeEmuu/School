package com.lvc.cds;

import com.google.protobuf.Message;

import com.lvc.cds.RaftProtos.AppendEntries;
import com.lvc.cds.RaftProtos.RequestVote;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class RaftNode {
    public enum State {FOLLOWER, LEADER, CANDIDATE}

    // Persistent State
    private int currentTerm = 0;
    private int votedFor = -1;
    private String id;
    private String leaderId;
    private Network network;

    ArrayList<Entry> log;

    // Volatile State
    private int commitIndex = 0;
    private int lastApplied = 0;

    // Leader State
    int[] nextIndex;
    int[] matchIndex;

    public State leader() {
        return null;
    }

    public State candidate() {
        return null;
    }

    public State follower() {
        Message mess = network.getIncomingMessage();
        switch (mess.getDescriptorForType().getName()){
            case "AppendEntries":
                AppendEntries message = (AppendEntries) mess;
                message.getTerm();
                break;
            case "RequestVote":
                break;
        }
        return null;
    }

    public void runNode(){
        State currentState = State.FOLLOWER;
        try {
            id = Inet4Address.getLocalHost().getHostAddress();
        }
        catch(UnknownHostException e){ }

        log = new ArrayList<>();
        network = new Network();

        while(true){
            switch(currentState){
                case FOLLOWER:
                    currentState = follower();
                    break;
                case LEADER:
                    currentState = leader();
                    break;
                case CANDIDATE:
                    currentState = candidate();
                    break;
            }
        }
    }

    class Entry{
        int term;
        RaftProtos.AppendEntries.Pair entry;
        public Entry(int term, RaftProtos.AppendEntries.Pair entry){
            this.term = term;
            this.entry = entry;
        }
    }

    //<editor-fold desc="Getters">
    public int getCurrentTerm() {
        return currentTerm;
    }

    public int getVotedFor() {
        return votedFor;
    }

    public String getId() {
        return id;
    }

    public int getCommitIndex() {
        return commitIndex;
    }

    public int getLastApplied() {
        return lastApplied;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public ArrayList<Entry> getLog() {
        return log;
    }
    //</editor-fold>
}
