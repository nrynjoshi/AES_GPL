package com.narayanjoshi.gplapplication.service.command.programming;

public class SleepCommand extends ProgrammingRootCommand {

    /**
     * {@inheritDoc}
     * This method will ignore this particular line for commenting code.
     * Nothing can be happened just no operation

     */
    @Override
    public void execute() {
        try{
            Thread.sleep(Long.parseLong(paramList.get(0)));
        }catch (Exception x){

        }
    }
}
