package com.lvc.cds;

import com.google.protobuf.Message;

public class tttt {
    public static void main(String[] args) {
        RaftProtos.AppendEntriesResponse.Builder a = RaftProtos.AppendEntriesResponse.newBuilder();
        a.setTerm(1);
        a.setSuccess(true);
        System.out.println(a.build().getDescriptorForType().getName());
    }
}
