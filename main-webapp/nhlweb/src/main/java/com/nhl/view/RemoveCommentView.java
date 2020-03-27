package com.nhl.view;

public class RemoveCommentView implements MsgObjectView {
    public String commentId;
    private String unused; // JSON cannot be parsed into this type unless there are more than two fields

    public RemoveCommentView(String commentId) {
        this.commentId = commentId;
    }

    public RemoveCommentView(String commentId, String unused) {
        this.commentId = commentId;
        this.unused = unused;
    }
}
