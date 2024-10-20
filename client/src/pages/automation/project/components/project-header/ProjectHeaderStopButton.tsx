import {Button} from '@/components/ui/button';
import {SquareIcon} from 'lucide-react';

const ProjectHeaderStopButton = () => (
    <Button
        className="hover:bg-muted"
        onClick={() => {
            // TODO
        }}
        size="icon"
        variant="ghost"
    >
        <SquareIcon className="h-5 text-destructive" />
    </Button>
);

export default ProjectHeaderStopButton;
