package linkedin;

import java.util.ArrayList;
import java.util.List;

import atm.Sleep;
import linkedin.jobs.Application;
import linkedin.jobs.Job;
import linkedin.profile.Skill;

public class JobHandler {
    private static JobHandler jobHandler = new JobHandler();
    List<Job> jobs = new ArrayList<>();


    public static JobHandler getInstance(){
        return jobHandler;
    }

    public Job postJob(User user, Job job){
        System.out.println("Posting job, please wait...");
        Sleep.sleep(1000);

        if(job.getUser() != user){
            System.out.println("You can't post this job...");
            return null;
        }

        jobs.add(job);
        System.out.println("Job posted successfully..");
        return job;
    }


    public List<Job> searchJobs(User user, String title, Skill skill){
        System.out.println("Searching relevant jobs, please wait..");
        Sleep.sleep(1000);

        List<Job> list = new ArrayList<>();
        for(Job job : jobs){
            if(job.getTitle() == title || job.getSkillsRequired().contains(skill)){
                list.add(job);
            }
        }

        return list;
    }

    public Application apply(User user, Job job, String resume){
        System.out.println("Submitting application, please wait..");
        Sleep.sleep(1000);

        Application application = new Application(user, resume);
        job.submit(application);
        System.out.println("Application submitted successfully...");
        return application;
    }
}
