package chapter9packagesandinterfaces.multipleinheritanceissues;

class Issue implements Beta {

    @Override
    public void save() {
        System.out.println("Your data is saved.");
    }

    @Override
    public void delete() {
        System.out.println("Your data is deleted.");
    }


}
